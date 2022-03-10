package com.sunglowsys.repository;

import com.sunglowsys.domain.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType , Long> {
    @Query("from RoomType room where room.name LIKE %?1%")
    List<RoomType> search(@RequestParam String searchText);

}
