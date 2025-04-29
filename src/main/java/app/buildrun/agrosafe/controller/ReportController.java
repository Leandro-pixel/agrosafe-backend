package app.buildrun.agrosafe.controller;

//import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.buildrun.agrosafe.entity.BurnReport;
import app.buildrun.agrosafe.entity.FireRiskPredictionResponse;
import app.buildrun.agrosafe.service.ReportService;

@RestController
@RequestMapping("/v1/reports")
@CrossOrigin(origins = "http://localhost:9000") 
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/burn")
public ResponseEntity<String> createBurnReport(@RequestBody CreateBurnReportDto reportDto) {
    System.out.println("Recebido relatório de queima do usuário: " + reportDto.getUserId());

    BurnReport report = new BurnReport();
    report.setUserId(reportDto.getUserId());
    report.setAverageTemperature(reportDto.getTemperaturaMediaDiaria());
    report.setHumidity(reportDto.getUmidadeRelativaAr());
    report.setPrecipitation(reportDto.getPrecipitacao());
    report.setSoilMoistureIndex(reportDto.getIndiceUmidadeSolo());
    report.setVegetationIndex(reportDto.getIndiceVegetacao());
    report.setLocation(reportDto.getLocalizacao());
    //report.setCreationTimestamp(LocalDateTime.parse(reportDto.getDataHora()));
    report.setBurnedArea(reportDto.getAreaQueimada());

    reportService.saveBurnReport(report);

    return ResponseEntity.ok("Relatório de queima recebido com sucesso!");
}


@GetMapping("/predict")
public ResponseEntity<FireRiskPredictionResponse> predictFireRisk(@RequestParam UUID userId) {
    FireRiskPredictionResponse prediction = reportService.predictFireRisk(userId);
    return ResponseEntity.ok(prediction);
}


}

