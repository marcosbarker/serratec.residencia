package com.residencia.biblioteca.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.biblioteca.entities.Emprestimos;
import com.residencia.biblioteca.biblioteca.repositories.AlunosRepository;
import com.residencia.biblioteca.biblioteca.repositories.EmprestimosRepository;
import com.residencia.biblioteca.biblioteca.repositories.LivrosRepository;
import com.residencia.biblioteca.biblioteca.vo.EmprestimoVO;

@Service
public class EmprestimosService {

	@Autowired
	public EmprestimosRepository emprestimoRepository;

	@Autowired
	public AlunosRepository alunoRepository;

	@Autowired
	public LivrosRepository livroRepository;

	public EmprestimoVO findById(Integer id) {
		Emprestimos emprestimo = emprestimoRepository.findById(id).get();
		EmprestimoVO emprestimoVO = converteEntidadeParaVO(emprestimo);
		return emprestimoVO;
	}

	public List<EmprestimoVO> findAll() {
		List<Emprestimos> listEmprestimo = emprestimoRepository.findAll();
		List<EmprestimoVO> listEmprestimoVO = new ArrayList<>();

		for (Emprestimos emprestimo : listEmprestimo) {
			EmprestimoVO emprestimoVO = converteEntidadeParaVO(emprestimo);

			listEmprestimoVO.add(emprestimoVO);
		}

		return listEmprestimoVO;
	}

	public List<Emprestimos> findAll(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Emprestimos> listEmprestimo = null;
		List<Emprestimos> listEmprestimoComPaginacao = null;

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
		Emprestimos novoEmprestimo = converteVOParaEntidade(emprestimoVO, null);
		emprestimoRepository.save(novoEmprestimo);
		return converteEntidadeParaVO(novoEmprestimo);
	}

	public EmprestimoVO update(EmprestimoVO emprestimoVO, Integer id) {
		Emprestimos emprestimo = converteVOParaEntidade(emprestimoVO, id);
		Emprestimos novoEmprestimo = emprestimoRepository.save(emprestimo);
		return converteEntidadeParaVO(novoEmprestimo);
	}

	public Long count() {
		return emprestimoRepository.count();
	}

	private EmprestimoVO converteEntidadeParaVO(Emprestimos emprestimo) {
		EmprestimoVO emprestimoVO = new EmprestimoVO();

		emprestimoVO.setCodigoEmprestimo(emprestimo.getCodigoEmprestimo());
		emprestimoVO.setCodigoLivro(emprestimo.getLivro().getCodigoLivro());
		emprestimoVO.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoVO.setDataEntrega(emprestimo.getDataEntrega());
		emprestimoVO.setNumeroMatriculaAluno(emprestimo.getAluno().getNumeroMatriculaAluno()); // potencial Java NullPointerException
		emprestimoVO.setNomeAluno(emprestimo.getAluno().getNome()); // potencial Java NullPointerException
		emprestimoVO.setValorEmprestimo(emprestimo.getValorEmprestimo());

		return emprestimoVO;
	}

	private Emprestimos converteVOParaEntidade(EmprestimoVO emprestimoVO, Integer id) {
		Emprestimos emprestimo = new Emprestimos();

		emprestimo.setAluno(alunoRepository.getById(emprestimoVO.getNumeroMatriculaAluno())); // potencial Java NullPointerException
		emprestimo.setCodigoEmprestimo((null == id) ? emprestimoVO.getCodigoEmprestimo() : id);
		emprestimo.setDataEmprestimo(emprestimoVO.getDataEmprestimo());
		emprestimo.setDataEntrega(emprestimoVO.getDataEntrega());
		emprestimo.setLivro(livroRepository.getById(emprestimoVO.getCodigoLivro())); // potencial Java NullPointerException
		emprestimo.setValorEmprestimo(emprestimoVO.getValorEmprestimo());

		return emprestimo;
	}

}