package com.sbs.demo5.domain.book.repository;

import com.sbs.demo5.domain.book.entity.Book;
import com.sbs.demo5.domain.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookRepositoryCustom {
    Page<Book> findByKw(String kwType, String kw, boolean isPublic, Pageable pageable);

    Page<Book> findByKw(Member author, String kwType, String kw, Pageable pageable);
}
