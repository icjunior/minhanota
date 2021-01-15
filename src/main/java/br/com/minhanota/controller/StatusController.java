package br.com.minhanota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.minhanota.config.NfeConfig;
import br.com.minhanota.controller.dto.StatusDTO;
import br.com.swconsultoria.nfe.Nfe;
import br.com.swconsultoria.nfe.dom.ConfiguracoesNfe;
import br.com.swconsultoria.nfe.dom.enuns.DocumentoEnum;
import br.com.swconsultoria.nfe.schema_4.retConsStatServ.TRetConsStatServ;

@RestController
@RequestMapping("/status")
public class StatusController {
	
	@Autowired
	private NfeConfig nfeConfig;

	@GetMapping
	public ResponseEntity<StatusDTO> consultaStatus(){
		try {
            // Inicia As Configurações - ver https://github.com/Samuel-Oliveira/Java_NFe/wiki/1-:-Configuracoes
            ConfiguracoesNfe config = nfeConfig.iniciaConfigurações();

            //Efetua Consulta
            TRetConsStatServ retorno = Nfe.statusServico(config, DocumentoEnum.NFE);

            //Resultado
            System.out.println();
            System.out.println("# Status: " + retorno.getCStat() + " - " + retorno.getXMotivo());
            
            return ResponseEntity.ok(new StatusDTO(retorno));
        } catch (Exception e) {
            System.err.println("# Erro: "+e.getMessage());
            return ResponseEntity.badRequest().build();
        }
	}
}
