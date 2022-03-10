package com.sunglowsys.service;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.repository.RoomTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService{

    private final Logger  log = LoggerFactory.getLogger(RoomTypeServiceImpl.class);
    private final RoomTypeRepository roomTypeRepository;

    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    @Override
    public RoomType save(RoomType roomType) {
        log.debug("request to create RoomTYpe : {}" ,roomType);
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType update(RoomType roomType) {
        log.debug("request to update RoomType : {}" ,roomType);
        return roomTypeRepository.save(roomType);
    }

    @Override
    public Page<RoomType> findAll(Pageable pageable) {
        log.debug("request to find hotelTypes");
        return roomTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<RoomType> findById(Long id) {
        log.debug("request to find hotelTypes : {} " ,id);
        return roomTypeRepository.findById(id);
    }

    @Override
    public List<RoomType> search(String searchText) {
        log.debug("request to search RoomType:{}" ,searchText);
        return roomTypeRepository.search(searchText);
    }

    @Override
    public void delete(Long id) {
        log.debug("request to delete roomType : {}" ,id);
        roomTypeRepository.deleteById(id);

    }
}
