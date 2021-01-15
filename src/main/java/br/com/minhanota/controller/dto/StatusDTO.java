package br.com.minhanota.controller.dto;

import br.com.swconsultoria.nfe.schema_4.retConsStatServ.TRetConsStatServ;
import lombok.Getter;

@Getter
public class StatusDTO {

	private String tpAmb;
	private String verAplic;
	private String cStat;
	private String xMotivo;
	private String cuf;
	private String dhRecbto;
	private String tMed;
	private String dhRetorno;
	private String xObs;
	private String versao;

	public StatusDTO(TRetConsStatServ retorno) {
		this.tpAmb = retorno.getTpAmb();
		this.verAplic = retorno.getVerAplic();
		this.cStat = retorno.getCStat();
		this.xMotivo = retorno.getXMotivo();
		this.cuf = retorno.getCUF();
		this.dhRecbto = retorno.getDhRecbto();
		this.tMed = retorno.getTMed();
		this.dhRetorno = retorno.getDhRetorno();
		this.xObs = retorno.getXObs();
		this.versao = retorno.getVersao();
	}

	public static StatusDTO converter(TRetConsStatServ retorno) {
	    	return new StatusDTO(retorno);
	    }
}
