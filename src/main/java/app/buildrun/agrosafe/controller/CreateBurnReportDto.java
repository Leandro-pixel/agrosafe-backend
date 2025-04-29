package app.buildrun.agrosafe.controller;

import java.util.UUID;

public class CreateBurnReportDto {
    private UUID userId;

    // Dados meteorológicos
    private Double temperaturaMediaDiaria;
    private Double umidadeRelativaAr;
    private Double precipitacao;

    // Dados de solo e vegetação
    private Double indiceUmidadeSolo;
    private Double indiceVegetacao;

    // Dados de incêndio
    private String localizacao;
    private String dataHora; // Pode ser um String no formato ISO, tipo "2025-04-27T18:00:00"
    private Double areaQueimada;

    public CreateBurnReportDto() {}

    // Getters e Setters
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Double getTemperaturaMediaDiaria() {
        return temperaturaMediaDiaria;
    }

    public void setTemperaturaMediaDiaria(Double temperaturaMediaDiaria) {
        this.temperaturaMediaDiaria = temperaturaMediaDiaria;
    }

    public Double getUmidadeRelativaAr() {
        return umidadeRelativaAr;
    }

    public void setUmidadeRelativaAr(Double umidadeRelativaAr) {
        this.umidadeRelativaAr = umidadeRelativaAr;
    }

    public Double getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(Double precipitacao) {
        this.precipitacao = precipitacao;
    }

    public Double getIndiceUmidadeSolo() {
        return indiceUmidadeSolo;
    }

    public void setIndiceUmidadeSolo(Double indiceUmidadeSolo) {
        this.indiceUmidadeSolo = indiceUmidadeSolo;
    }

    public Double getIndiceVegetacao() {
        return indiceVegetacao;
    }

    public void setIndiceVegetacao(Double indiceVegetacao) {
        this.indiceVegetacao = indiceVegetacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Double getAreaQueimada() {
        return areaQueimada;
    }

    public void setAreaQueimada(Double areaQueimada) {
        this.areaQueimada = areaQueimada;
    }
}
