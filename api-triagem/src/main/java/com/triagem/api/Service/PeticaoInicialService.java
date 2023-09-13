package com.triagem.api.Service;

import com.triagem.api.Model.Imagem;
import com.triagem.api.Model.ImagemID;
import com.triagem.api.Model.PeticaoInicial;
import com.triagem.api.Model.Processo;
import com.triagem.api.Repository.PeticaoInicialRepository;
import com.triagem.api.Repository.ProcessoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Service
public class PeticaoInicialService {
    PeticaoInicialRepository repository;
    ProcessoRepository processoRepository;

    public PeticaoInicialService(PeticaoInicialRepository repository, ProcessoRepository processoRepository){
        this.repository = repository;
        this.processoRepository = processoRepository;
    }
    //Adicionar
    public PeticaoInicial insert(PeticaoInicial peticaoInicial){
        if (peticaoInicial.getProcesso() != null){
            Processo aux = processoRepository.save(peticaoInicial.getProcesso());
            peticaoInicial.setProcesso(aux);
            return repository.save(peticaoInicial);
        }
        PeticaoInicial result = repository.save(peticaoInicial);
        return result;
    }
    //Consultar
    public PeticaoInicial findById(Long id){
        Optional<PeticaoInicial> peticaoInicial = repository.findById(id);
        return peticaoInicial.get();
    }

    public List<PeticaoInicial> findAll(){
        Sort sort = Sort.by("id").descending();
        return this.repository.findAll(sort);
    }
    //Atualizar

    public PeticaoInicial atualizarInfos(Long idPeticao, Processo processo){
        Optional<PeticaoInicial> checkPeticao = repository.findById(idPeticao);
        if (checkPeticao.isPresent()){
            PeticaoInicial currPeticao = checkPeticao.get();
            Processo currProcesso = currPeticao.getProcesso();
            if (currProcesso == null){
                currProcesso = new Processo();
            }
            if (processo.getJustGratuita() != null && processo.getJustGratuita() != currProcesso.getJustGratuita()){
                currProcesso.setJustGratuita(processo.getJustGratuita());
            }
            if (processo.getValorCausa() != null && processo.getValorCausa() != currProcesso.getValorCausa()){
                currProcesso.setValorCausa(processo.getValorCausa());
            }
            if (processo.getPedidoLiminar() != null && processo.getPedidoLiminar() != currProcesso.getPedidoLiminar()){
                currProcesso.setPedidoLiminar(processo.getPedidoLiminar());
            }
            if (processo.getPartes() != null &&
                    processo.getPartes() != currProcesso.getPartes()){
                currProcesso.setPartes(processo.getPartes());
            }

            processoRepository.save(currProcesso);
            currPeticao.setProcesso(currProcesso);
            return repository.save(currPeticao);
        }else{
            return null;
        }

    }
    public PeticaoInicial atualizarNuvem(Long idPeticao, ImagemID idImagem){
        Optional<PeticaoInicial> checkPeticao = repository.findById(idPeticao);
        if (checkPeticao.isPresent()){
            PeticaoInicial currPeticao = checkPeticao.get();
            currPeticao.setNuvem(idImagem.getIdNuvem());
            return repository.save(currPeticao);
        }else{
            return null;
        }
    }
    //Remover
    /**
     *TODO: Deletar processo associado a petição
     *      Deixar inativo [melhor que deletar]
     */
    public void delete(Long id){
        repository.deleteById(id);
    }

}