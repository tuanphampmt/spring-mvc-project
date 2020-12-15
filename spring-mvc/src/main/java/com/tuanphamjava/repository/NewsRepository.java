package com.tuanphamjava.repository;


import com.tuanphamjava.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> { // Long la kieu du lieu khoa chinh


}
