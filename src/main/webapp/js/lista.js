function lista() {
	
}

lista.prototype.setTabela = function(seletorTabela, opcoes) {
			
	this.tabela = $(seletorTabela).dataTable({
		dom: 'Zlfrtip',
		bSort : true,
		bFilter : false,
		bLengthChange : false,
		language : {
			"sProcessing": "Processando...",
			paginate : {
				previous : opcoes.previous,
				next : opcoes.next,
				first: opcoes.first,
				last: opcoes.last
			},
			info: opcoes.info,
            infoEmpty: opcoes.infoEmpty,
            zeroRecords: opcoes.zeroRecords
		},
		serverSide : true,
		ajax : {
			
			url: dominio + opcoes.url + opcoes.funcExcluir
	
		},
		processing : true,
		bStateSave: false,
		iDisplayLength: 10,
		pagingType: "full_numbers"
	});
	
}

lista.prototype.setParametros = function(parametros){
	
	this.parametros = parametros;
}

lista.prototype.atualizar = function(parametros, optUrl){
			
	this.setParametros($.trim(parametros));
	
	var url = dominio + optUrl;
	
		
	if($.trim(this.parametros) != ''){

		url = url + this.parametros;
		
	}	
	
	this.tabela.api().ajax.url(url).load();
	this.parametros = '';
}