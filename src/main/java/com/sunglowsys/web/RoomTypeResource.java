package com.sunglowsys.web;

import com.sunglowsys.domain.RoomType;
import com.sunglowsys.service.RoomTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class RoomTypeResource {
    private final Logger log = LoggerFactory.getLogger(RoomTypeResource.class);
    private final RoomTypeService roomTypeService;

    public RoomTypeResource(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }
    @GetMapping
    public ModelAndView home() {
        log.debug("web request to get roomTypes");
        Page<RoomType> page = roomTypeService.findAll(PageRequest.of(0,20));
        List<RoomType> roomTypes = page.getContent();
        return new ModelAndView("index" , "roomTypes" ,roomTypes);
    }
    @GetMapping("/roomTypes/create")
    public ModelAndView createRoomTypeForm(@ModelAttribute RoomType roomType) {
        log.debug("web request to create roomTypeForm");
        return new ModelAndView("add-roomType" , "roomType" , roomType);
    }
    @PostMapping("/roomTypes")
    public ModelAndView createRoomType(@ModelAttribute RoomType roomType) {
        log.debug("web request to create roomtype : {}" ,roomType );
        roomTypeService.save(roomType);
        return new ModelAndView("redirect:/" , "roomType" ,roomType);

    }
    @GetMapping("/roomTypes/update/{id}")
    public ModelAndView updateRoomType(@ModelAttribute RoomType roomType , @PathVariable Long id) {
        log.debug("web request to update roomType : {}" ,id);
        roomType = roomTypeService.findById(id).get();
        return new ModelAndView("add-roomType" , "roomType" , roomType);

    }
    @GetMapping("/roomTypes/delete/{id}")
    public ModelAndView deleteRoomType(@PathVariable Long id) {
        log.debug("web request to delete roomType : {}" , id);
        roomTypeService.delete(id);
        return new ModelAndView("redirect:/");
    }

}
