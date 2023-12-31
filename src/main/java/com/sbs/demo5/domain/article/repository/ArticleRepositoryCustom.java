package com.sbs.demo5.domain.article.repository;

import com.sbs.demo5.domain.article.entity.Article;
import com.sbs.demo5.domain.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleRepositoryCustom {
    Page<Article> findByKw(Board board, String kwType, String kw, Pageable pageable);
}
