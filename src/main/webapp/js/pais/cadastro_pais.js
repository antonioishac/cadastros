$(document).ready(function() {
	
	$('#cadastraPais').addClass('active');
			
	$('#paisForm').submit(function (e) {
		
		if ($('#nomePtBrInput').val() != '' && $('#sigla2Input').val() != '') {
			
			e.preventDefault();
			
			var formdata = $("#paisForm").serialize();
			
			$.ajax({
				type: "POST", 
				url: dominio + '/pais/salvarPais.do', 
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
	
	$('#paisForm').validate({

		rules: {
			nomePtBr: {
				required: true,
				minlength: 2				
			},
			sigla2: {
				required: true,
				minlength: 2
			}
		},
		messages: {

			nomePtBr:{
				required: 'Campo nomePtBr obrigatório',
				minlength: 'Tamannho mínimo 2 caracteres',
				maxlength: 'Tamanho máximo 2 caracteres'	
			},
			sigla2: {
				required: 'Campo descrição obrigatório',
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