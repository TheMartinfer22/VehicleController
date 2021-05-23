package team.martin.controlador.api.controller.exceptionhandler;

import java.time.LocalDateTime;

public class Resultado {

    private Integer status;
    private LocalDateTime time;
    private String motivo;

    public Integer getStatus() {
        return status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
