package com.br.projeto.estoque.contoledecaixa.service.impl;
import com.br.projeto.estoque.contoledecaixa.dto.VendaDTO;
import com.br.projeto.estoque.contoledecaixa.model.Venda;
import com.br.projeto.estoque.contoledecaixa.repository.VendaRepository;
import com.br.projeto.estoque.contoledecaixa.service.VendaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<VendaDTO> listarVendas() {
        List<Venda> vendas = vendaRepository.findAll();
        return vendas.stream()
                .map(venda -> modelMapper.map(venda, VendaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VendaDTO salvarVenda(VendaDTO vendaDTO) {
        Venda venda = modelMapper.map(vendaDTO, Venda.class);
        venda = vendaRepository.save(venda);
        return modelMapper.map(venda, VendaDTO.class);
    }

    @Override
    public VendaDTO atualizarVenda(Long id) {
        return null;
    }

    @Override
    public VendaDTO buscarVendaPorId(Long id) {
        Venda venda = vendaRepository.findById(id).orElse(null);
        return modelMapper.map(venda, VendaDTO.class);
    }

    @Override
    public void deletarVenda(Long id) {
        vendaRepository.deleteById(id);
    }
}