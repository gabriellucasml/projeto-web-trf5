package com.triagem.api.Repository;

import com.triagem.api.Model.Stopwords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopwordsRepository extends JpaRepository<Stopwords, String> {

}
