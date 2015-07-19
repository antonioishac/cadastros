$(document).ready(function() {
	
	$('#cadastraUf').addClass('active');
			
	$('#ufForm').submit(function (e) {
		
		if ($('#nomeInput').val() != '' && $('#siglaInput').val() != '') {
			
			e.preventDefault();
			
			var formdata = $("#ufForm").serialize();
			
			$.ajax({
				type: "POST", 
				url: dominio + '/uf/salvarUf.do', 
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
	
	$('#ufForm').validate({

		rules: {
			nome: {
				required: true,
				minlength: 2				
			},
			sigla: {
				required: true,
				minlength: 2
			}
		},
		messages: {

			nome:{
				required: 'Campo nome obrigatório',
				minlength: 'Tamannho mínimo 2 caracteres',
				maxlength: 'Tamanho máximo 2 caracteres'	
			},
			sigla: {
				required: 'Campo sigla obrigatório',
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
		
		$('#optPais').val('');
		
		$('#idInput').val(null);
	}
	
});