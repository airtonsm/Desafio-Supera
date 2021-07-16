package com.airton.desafiosupera.service;

import com.airton.desafiosupera.dto.ShopcartDTO;
import com.airton.desafiosupera.entities.Shopcart;
import com.airton.desafiosupera.exception.DataBaseException;
import com.airton.desafiosupera.exception.ResourcesNotFoundException;
import com.airton.desafiosupera.mapper.ShopcartMapper;
import com.airton.desafiosupera.repository.ShopcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ShopcartService {

    @Autowired
    private ShopcartRepository repository;

    public List<ShopcartDTO> findAll(String sortAttribute) {
        return ShopcartMapper.toDTOList(repository.findAll(), sortAttribute);
    }

    public ShopcartDTO findById(Long id, String sortAttribute) {
        Shopcart shopcart = repository.findById(id).orElseThrow(() -> new ResourcesNotFoundException(id));
        return ShopcartMapper.toDTO(shopcart, sortAttribute);
    }

    public ShopcartDTO findById(Long id) {
        return findById(id, null);
    }

    public ShopcartDTO checkout(Long id) {
        ShopcartDTO dto = this.findById(id);
        dto.calcPrice();
        return dto;
    }

    public Shopcart insert(Shopcart obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public Shopcart update(Long id, Shopcart obj) {
        try {
            Shopcart entity = repository.getOne(id);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException(id);
        }
    }

}
