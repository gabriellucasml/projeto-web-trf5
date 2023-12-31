package com.triagem.api.Service;


import com.triagem.api.Model.Imagem;
import com.triagem.api.Repository.ImagemRepository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImagemService {
    @Autowired
    private ImagemRepository repository;

    @Autowired
    private EntityManager entityManager;

    public ImagemService(ImagemRepository repository){
        this.repository = repository;
    }
    //Adicionar
    public String insert(MultipartFile file) throws IOException {
        Imagem curr = new Imagem();
        curr.setNome(StringUtils.cleanPath(file.getOriginalFilename()));
        curr.setContentType("image/png");
        curr.setData(file.getBytes());
        curr.setSize(file.getSize());

        Imagem res = repository.save(curr);
        return res.getId();
    }
    //Consultar
    public Optional<Imagem> findById(String id){
        Optional<Imagem> result = repository.findById(id);
        return result;
    }

    public List<Imagem> findAll(boolean isDeleted){
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedImagemFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<Imagem> imagens = repository.findAll();
        session.disableFilter("deletedImagemFilter");
        return imagens;
    }
    //Atualizar
    // TODO
    //Remover
    public void delete(String id){
        repository.deleteById(id);
    }
}
