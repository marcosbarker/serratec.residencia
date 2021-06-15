package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.repositories.AlunoRepository;
import com.residencia.biblioteca.repositories.EmprestimoRepository;
import com.residencia.biblioteca.repositories.LivroRepository;
import com.residencia.biblioteca.vo.EmprestimoVO;

@Service
public class EmprestimoService {

	@Autowired
	public EmprestimoRepository emprestimoRepository;

	@Autowired
	public AlunoRepository alunoRepository;

	@Autowired
	public LivroRepository livroRepository;

	public EmprestimoVO findById(Integer id) {
		Emprestimo emprestimo = emprestimoRepository.findById(id).get();
		EmprestimoVO emprestimoVO = converteEntidadeParaVO(emprestimo);
		return emprestimoVO;
	}

	public List<EmprestimoVO> findAll() {
		List<Emprestimo> listEmprestimo = emprestimoRepository.findAll();
		List<EmprestimoVO> listEmprestimoVO = new ArrayList<>();

		for (Emprestimo emprestimo : listEmprestimo) {
			EmprestimoVO emprestimoVO = converteEntidadeParaVO(emprestimo);

			listEmprestimoVO.add(emprestimoVO);
		}

		return listEmprestimoVO;
	}

	public List<Emprestimo> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Emprestimo> listEmprestimo = null;
		List<Emprestimo> listEmprestimoComPaginacao = null;

		try {
			if (null != pagina && null != qtdRegistros) {
				page = PageRequest.of(pagina, qtdRegistros);
				listEmprestimoComPaginacao = emprestimoRepository.findAll(page).getContent();

				return listEmprestimoComPaginacao;
			} else {
				listEmprestimo = emprestimoRepository.findAll();

				return listEmprestimo;
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de emprestimos ::" + e.getMessage());
		}
	}

	public EmprestimoVO save(EmprestimoVO emprestimoVO) {
		Emprestimo novoEmprestimo = converteVOParaEntidade(emprestimoVO, null);
		emprestimoRepository.save(novoEmprestimo);
		return converteEntidadeParaVO(novoEmprestimo);
	}

	public EmprestimoVO update(EmprestimoVO emprestimoVO, Integer id) {
		Emprestimo emprestimo = converteVOParaEntidade(emprestimoVO, id);
		Emprestimo novoEmprestimo = emprestimoRepository.save(emprestimo);
		return converteEntidadeParaVO(novoEmprestimo);
	}

	public Long count() {
		return emprestimoRepository.count();
	}

	private EmprestimoVO converteEntidadeParaVO(Emprestimo emprestimo) {
		EmprestimoVO emprestimoVO = new EmprestimoVO();

		emprestimoVO.setCodigoEmprestimo(emprestimo.getCodigoEmprestimo());
		emprestimoVO.setCodigoLivro(emprestimo.getLivro().getCodigoLivro());
		emprestimoVO.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoVO.setDataEntrega(emprestimo.getDataEntrega());
		emprestimoVO.setNumeroMatriculaAluno(emprestimo.getAluno().getNumeroMatriculaAluno()); // potencial Java NullPointerException
		emprestimoVO.setNomeAluno(emprestimo.getAluno().getNomeAluno()); // potencial Java NullPointerException
		emprestimoVO.setValorEmprestimo(emprestimo.getValorEmprestimo());

		return emprestimoVO;
	}

	private Emprestimo converteVOParaEntidade(EmprestimoVO emprestimoVO, Integer id) {
		Emprestimo emprestimo = new Emprestimo();

		emprestimo.setAluno(alunoRepository.getById(emprestimoVO.getNumeroMatriculaAluno())); // potencial Java NullPointerException
		emprestimo.setCodigoEmprestimo((null == id) ? emprestimoVO.getCodigoEmprestimo() : id);
		emprestimo.setDataEmprestimo(emprestimoVO.getDataEmprestimo());
		emprestimo.setDataEntrega(emprestimoVO.getDataEntrega());
		emprestimo.setLivro(livroRepository.getById(emprestimoVO.getCodigoLivro())); // potencial Java NullPointerException
		emprestimo.setValorEmprestimo(emprestimoVO.getValorEmprestimo());

		return emprestimo;
	}

}
