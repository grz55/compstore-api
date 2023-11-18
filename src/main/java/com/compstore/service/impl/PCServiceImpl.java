package com.compstore.service.impl;

import com.compstore.dto.PagingAndSortingMetadataDTO;
import com.compstore.dto.pc.PCDTO;
import com.compstore.dto.pc.PCFilteringRequestDTO;
import com.compstore.dto.pc.PCFilteringResponseDTO;
import com.compstore.dto.pc.PCSimpleDTO;
import com.compstore.entity.pc.PCEntity;
import com.compstore.exception.NotFoundException;
import com.compstore.mapper.PCMapper;
import com.compstore.repository.pc.PCRepository;
import com.compstore.repository.pc.PCSpecification;
import com.compstore.service.IPCService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PCServiceImpl implements IPCService {

    private final PCMapper pcMapper;
    private final PCRepository pcRepository;

    @Override
    public PCDTO getPCById(UUID pcId) {
        Optional<PCEntity> pcById = pcRepository.findById(pcId);
        if (pcById.isPresent()) {
            return pcMapper.toDTO(pcById.get());
        } else {
            throw new NotFoundException("PC not found with id: " + pcId);
        }
    }

    @Override
    public PCFilteringResponseDTO searchPC(PCFilteringRequestDTO pcFilteringRequestDTO) {
        Pageable pageRequest =
                pcFilteringRequestDTO.getPagingAndSortingRequest() != null
                        ? PageRequest.of(
                                pcFilteringRequestDTO.getPagingAndSortingRequest().getPageNumber(),
                                pcFilteringRequestDTO.getPagingAndSortingRequest().getPageSize())
                        : PageRequest.of(0, 10);

        Page<PCEntity> pcsFound =
                pcRepository.findAll(PCSpecification.filterPC(pcFilteringRequestDTO), pageRequest);

        List<PCEntity> pcs = pcsFound.getContent();
        List<PCSimpleDTO> simplePCs = pcMapper.toPCSimpleDTOList(pcs);

        PagingAndSortingMetadataDTO pagingAndSortingMetadataDTO = new PagingAndSortingMetadataDTO();
        pagingAndSortingMetadataDTO.setPageNumber(pcsFound.getNumber());
        pagingAndSortingMetadataDTO.setPageSize(pcsFound.getSize());
        pagingAndSortingMetadataDTO.setPagesCount(pcsFound.getTotalPages());
        pagingAndSortingMetadataDTO.setElementsCount(pcsFound.getNumberOfElements());

        PCFilteringResponseDTO pcFilteringResponseDTO = new PCFilteringResponseDTO();
        pcFilteringResponseDTO.setPcs(simplePCs);
        pcFilteringResponseDTO.setPagingAndSortingMetadata(pagingAndSortingMetadataDTO);
        return pcFilteringResponseDTO;
    }
}
