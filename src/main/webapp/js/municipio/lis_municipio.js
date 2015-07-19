$(document).ready(function(){
	
	$('#listaMunicipio').addClass('active');
	
});

function LisMunicipio(){
	
	this.parametros = '';
	$charset="utf8";	
}

LisMunicipio.prototype.setTabela = function(seletorTabela, opcoes) {
			
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
			
			url: dominio + "/municipio/listarMunicipio.do?funcExcluir=" + opcoes.funcExcluir
	
		},
		processing : true,
		bStateSave: false,
		iDisplayLength: 10,
		pagingType: "full_numbers"
	});
	
}

LisMunicipio.prototype.setParametros = function(parametros){
	
	this.parametros = parametros;
}

LisMunicipio.prototype.atualizar = function(parametros){
	
	this.setParametros($.trim(parametros));
	
	var url = dominio + "/municipio/listarMunicipio.do";
	
	if($.trim(this.parametros) != ''){

		url = url + this.parametros;
		
	}	
	
	this.tabela.api().ajax.url(url).load();
	this.parametros = '';
}

function limpaBusca(){
	
	$('#inputNome').val('');
	$('#inputUf').val('');
	
	$('#inputNome').focus();
	
}

var municipio = new LisMunicipio();