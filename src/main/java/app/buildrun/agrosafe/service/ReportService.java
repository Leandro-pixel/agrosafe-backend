package app.buildrun.agrosafe.service;

import org.springframework.stereotype.Service;

import app.buildrun.agrosafe.entity.BurnReport;
import app.buildrun.agrosafe.entity.FireRiskPredictionResponse;
import app.buildrun.agrosafe.repository.BurnReportRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ReportService {

    private final BurnReportRepository burnReportRepository;

    public ReportService(BurnReportRepository burnReportRepository) {
        this.burnReportRepository = burnReportRepository;
    }

    public void saveBurnReport(BurnReport report) {
        burnReportRepository.save(report);
    }
    

    
public FireRiskPredictionResponse predictFireRisk(UUID userId) {
    List<BurnReport> reports = burnReportRepository.findByUserId(userId);
    
    FireRiskPredictionResponse response = new FireRiskPredictionResponse();

    if (reports.isEmpty()) {
        response.setMessage("Nenhum relatório encontrado para este usuário.");
        response.setRiskLevel("Nenhum risco");
        return response;
    }

    // Lógica de previsão (a mesma que você já tem)
    double avgTemperature = reports.stream()
        .mapToDouble(BurnReport::getAverageTemperature)
        .average()
        .orElse(0.0);

    double avgHumidity = reports.stream()
        .mapToDouble(BurnReport::getHumidity)
        .average()
        .orElse(100.0);

    double avgSoilMoisture = reports.stream()
        .mapToDouble(BurnReport::getSoilMoistureIndex)
        .average()
        .orElse(100.0);

    // Avaliação do risco
    if (avgTemperature > 30 && avgHumidity < 30 && avgSoilMoisture < 40) {
        response.setMessage("Alerta: Risco de queima nos próximos 5 dias.");
        response.setRiskLevel("Alto");
        response.setAdditionalInfo("Temperatura alta, baixa umidade e solo seco.");
    } else if (avgTemperature > 28 && avgHumidity < 40) {
        response.setMessage("Atenção: Possível risco de queima em 10 dias.");
        response.setRiskLevel("Médio");
        response.setAdditionalInfo("Temperatura elevada e umidade baixa.");
    } else {
        response.setMessage("Tudo seguro: Sem risco de queima próximo.");
        response.setRiskLevel("Baixo");
        response.setAdditionalInfo("Condições normais de temperatura e umidade.");
    }

    return response;
}
}
