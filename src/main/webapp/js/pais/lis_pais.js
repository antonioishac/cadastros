$(document).ready(function(){
	
	$('#listaPais').addClass('active');
	
});

function LisPais(){
	
	this.parametros = '';
	$charset="utf8";	
}

LisPais.prototype.setTabela = function(seletorTabela, opcoes) {
			
	this.tabela = $(seletorTabela).dataTable({
		
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
			
			url: dominio + "/pais/listarPais.do?funcExcluir=" + opcoes.funcExcluir
	
		},
		processing : true,
		bStateSave: false,
		iDisplayLength: 10,
		pagingType: "full_numbers"
	});
	
}

LisPais.prototype.setParametros = function(parametros){
	
	this.parametros = parametros;
}

LisPais.prototype.atualizar = function(parametros){
	
	this.setParametros($.trim(parametros));
	
	var url = dominio + "/pais/listarPais.do";
	
	if($.trim(this.parametros) != ''){

		url = url + this.parametros;
		
	}	
	
	this.tabela.api().ajax.url(url).load();
	this.parametros = '';
}

function limpaBusca(){
	
	$('#inputNome').val('');
	$('#inputCodigo').val('');
	
	$('#inputNome').focus();
	
}

var pais = new LisPais();