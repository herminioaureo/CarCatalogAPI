package com.herminio.carcatalog.controller;

import com.herminio.carcatalog.dto.CarRequestDTO;
import com.herminio.carcatalog.dto.CarsResponseDTO;
import com.herminio.carcatalog.entity.CarsEntity;
import com.herminio.carcatalog.repository.CarsRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;


@RestController
@RequestMapping("car")
public class CarController {

    private static final Logger logger = LogManager.getLogger(CarController.class);
    @Autowired
    private CarsRepository repository;
    @GetMapping
    public List<CarsResponseDTO> findAll() {
        logger.info("Iniciando consulta de carros no banco de dados...");
        List<CarsResponseDTO> listDTO = new ArrayList<CarsResponseDTO>();

        for (CarsEntity entity : repository.findAll()) {
            listDTO.add(convertEntityToDTO(entity));
        }
        logger.info("Busca de carros no banco de dados concluida... carros retornados: " + listDTO.size());
        return listDTO;
    }
    @PostMapping
    public void saveCar(@RequestBody CarRequestDTO request) {
        logger.info("Iniciando consulta de carros no banco de dados...");
        repository.save(convertDTOtoEntity(request));
        logger.info("Carro salvo com sucesso");
    }

    private CarsResponseDTO convertEntityToDTO(CarsEntity entity) {
        CarsResponseDTO dto = new CarsResponseDTO();

        if (entity != null) {
            dto.setId(entity.getId());
            dto.setModel(entity.getModel());
            dto.setPrice(entity.getPrice());
            dto.setYear(entity.getYear());
            dto.setImage(entity.getImage());
        }
        return dto;
    }

    private CarsEntity convertDTOtoEntity(CarRequestDTO requestDTO) {
        CarsEntity entity = new CarsEntity();

        if (requestDTO != null) {
            entity.setModel(requestDTO.getModel());
            entity.setYear(requestDTO.getYear());
            entity.setPrice(requestDTO.getPrice());
            entity.setImage(requestDTO.getImage());
        }
        return entity;
    }

}
