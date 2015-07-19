$(document).ready(function(){
	
	$('#listaUf').addClass('active');
	
});

function LisUf(){
	
	this.parametros = '';
	$charset="utf8";	
}

LisUf.prototype.setTabela = function(seletorTabela, opcoes) {
			
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
			
			url: dominio + "/uf/listarUf.do?funcExcluir=" + opcoes.funcExcluir
	
		},
		processing : true,
		bStateSave: false,
		iDisplayLength: 10,
		pagingType: "full_numbers"
	});
	
}

LisUf.prototype.setParametros = function(parametros){
	
	this.parametros = parametros;
}

LisUf.prototype.atualizar = function(parametros){
	
	this.setParametros($.trim(parametros));
	
	var url = dominio + "/uf/listarUf.do";
	
	if($.trim(this.parametros) != ''){

		url = url + this.parametros;
		
	}	
	
	this.tabela.api().ajax.url(url).load();
	this.parametros = '';
}

function limpaBusca(){
	
	$('#inputNome').val('');
	$('#inputSigla').val('');
	
	$('#inputNome').focus();
	
}

var uf = new LisUf();