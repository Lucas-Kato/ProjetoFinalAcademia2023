package br.com.kaikei.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class AgenciaDTO {
    private String banco;
    private String agencia;
    private BigDecimal valorMovimento;
    private String tipoMovimento;

    /**
     * Construtor da classe AgenciaDTO
     *
     * @param banco             o nome do banco
     * @param agencia           o número da agência
     * @param valorMovimento    o valor do movimento
     * @param tipoMovimento     o tipo de movimento
     */
    public AgenciaDTO(String banco, String agencia, BigDecimal valorMovimento, String tipoMovimento) {
        this.banco = banco;
        this.agencia = agencia;
        this.valorMovimento = valorMovimento;
        this.tipoMovimento = tipoMovimento;
    }

    /**
     * Soma um valor ao valor do movimento atual.
     *
     * @param valorMovimento o valor a ser somado
     */
    public void somarValor(BigDecimal valorMovimento) {
        this.valorMovimento = this.valorMovimento.add(valorMovimento);
    }

    /**
     * Verifica se o objeto AgenciaDTIO é igual a outro objeto
     *
     * @param o o objeto a ser comparado
     * @return true se os objetos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgenciaDTO agenciaDTO = (AgenciaDTO) o;
        return Objects.equals(banco, agenciaDTO.banco) && Objects.equals(agencia, agenciaDTO.agencia) && Objects.equals(tipoMovimento, agenciaDTO.tipoMovimento);
    }

    /**
     * Retorna o valor do hashcode do objeto AgenciaDTO.
     *
     * @return o valor do hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(banco, agencia, tipoMovimento);
    }
}
