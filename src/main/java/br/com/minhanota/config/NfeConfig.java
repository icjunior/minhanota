package br.com.minhanota.config;

import java.io.FileNotFoundException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.swconsultoria.certificado.Certificado;
import br.com.swconsultoria.certificado.CertificadoService;
import br.com.swconsultoria.certificado.exception.CertificadoException;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.AmbienteEnum;
import br.com.swconsultoria.nfe.dom.enuns.EstadosEnum;
import br.com.swconsultoria.nfe.exception.NfeException;

@Configuration
public class NfeConfig {

	@Bean
	public ConfiguracoesNfe iniciaConfigurações() throws NfeException, FileNotFoundException, CertificadoException {
		Certificado certificado = CertificadoService
				.certificadoPfx("/Users/ismaelcostajunior/Downloads/certificados/09376437000107.pfx", "123456");

		return ConfiguracoesNfe.criarConfiguracoes(EstadosEnum.SP, AmbienteEnum.HOMOLOGACAO, certificado,
				"/Users/ismaelcostajunior/projetos/Schemas");
	}
}
