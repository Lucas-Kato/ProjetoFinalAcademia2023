package br.com.kaikei.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
public class ContaDTO {
    private String banco;
    private String agencia;
    private String conta;
    private BigDecimal valorMovimento;
    private String tipoMovimento;

    /**
     * Contrutor da classe AgenciaDTO
     *
     * @param banco             o nome do banco
     * @param agencia           o núemro da agência
     * @param conta             o número da conta
     * @param valorMovimento    o valor do movimento
     * @param tipoMovimento     o tipo de movimento
     */
    public ContaDTO(String banco, String agencia, String conta, BigDecimal valorMovimento, String tipoMovimento) {
        this.conta = conta;
        this.banco = banco;
        this.agencia = agencia;
        this.valorMovimento = valorMovimento;
        this.tipoMovimento = tipoMovimento;
    }

    /**
     * Soma um valor ao valor do movimento atual.
     *
     * @param valorMovimento o valor a ser somado.
     */
    public void somarValor(BigDecimal valorMovimento) {
        this.valorMovimento = this.valorMovimento.add(valorMovimento);
    }

    /**
     * Verifica se o objeto ContaDTO é igual a outro objeto.
     *
     * @param o o objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaDTO contaDTO = (ContaDTO) o;
        return Objects.equals(banco, contaDTO.banco) && Objects.equals(agencia, contaDTO.agencia) && Objects.equals(tipoMovimento, contaDTO.tipoMovimento);
    }

    /**
     * Retorna o valor do hashcode do objeto ContaDTO.
     *
     * @return o valor do hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(banco, agencia, tipoMovimento);
    }
}
