package com.example.demo.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class RenderizadorPaginas<T> {

	private String url;
	private Page<T> page;
	private int totalPage;
	private int nElemPorPag;
	private int pagActual;
	private List<ElementosPagina> paginas;

	public RenderizadorPaginas(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.paginas = new ArrayList<ElementosPagina>();

		totalPage = page.getTotalPages();
		nElemPorPag = page.getSize();
		pagActual = page.getNumber() + 1;

		int desde, hasta;
		desde = 1;
		hasta = totalPage;

		for (int i = 0; i < hasta; i++) {
			paginas.add(new ElementosPagina(desde + i, pagActual == desde + i));
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPagActual() {
		return pagActual;
	}

	public void setPagActual(int pagActual) {
		this.pagActual = pagActual;
	}

	public List<ElementosPagina> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<ElementosPagina> paginas) {
		this.paginas = paginas;
	}

}
