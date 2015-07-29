$(document).ready(function() {
	
	$('#cadastraMunicipio').addClass('active');
			
	$('#municipioForm').submit(function (e) {
		
		if ($('#inputUf').val() != '' && $('#nomeInput').val() != '') {
			
			e.preventDefault();
			
			var formdata = $("#municipioForm").serialize();
			
			$.ajax({
				type: "POST", 
				url: dominio + '/municipio/salvarPais.do', 
				data: formdata, 
				success: function(e){
								
					limpaCampos();
					$('#mensagem').html(e);				
					
				}, error: function (er) {
					alert('Erro: ' + er);
				} 
			});			
			
		}					
	});
	
	$('#municipioForm').validate({

		rules: {
			ufInput: {
				required: true,
				minlength: 2				
			},
			nomr: {
				required: true,
				minlength: 2
			}
		},
		messages: {

			ufInput:{
				required: 'Campo UF obrigatório',
				minlength: 'Tamannho mínimo 2 caracteres',
				maxlength: 'Tamanho máximo 2 caracteres'	
			},
			nome: {
				required: 'Campo descrição obrigatório',
				minlength: 'Tamannho mínimo 2 caracteres',
				minlength: 'Tamanho mínimo 2 caracteres'
			}
		},
		highlight: function(element) {
            $(element).closest('.row').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.row').removeClass('has-error');
        },				        
        errorClass: 'help-block',
        errorPlacement: function(error, element) {
            if(element.parent('input').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        }						
	});

	function limpaCampos() {
		$('input[id*="Input"]').each(function () {
			$(this).val('');
		});
	}
	
});