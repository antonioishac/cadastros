$(document).ready(function() {
	
	$('#cadastraCep').addClass('active');
	
	$('#inputCep').mask('99999-999');
			
	$('#cepForm').submit(function (e) {
						
		if ($('#inputLogradouro').val() != '') {
			
			e.preventDefault();
			
			var formdata = $('#cepForm').serialize();
			
			$.ajax({
				type: "POST", 
				url: dominio + '/cep/salvarCep.do', 
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
	
	$('#cepForm').validate({

		rules: {			
			logradouro: {
				required: true,
				minlength: 2
			}
		},
		messages: {

			logradouro:{
				required: 'Campo Logradouro obrigatório',
				minlength: 'Tamannho mínimo 2 caracteres',
				maxlength: 'Tamanho máximo 2 caracteres'	
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
		
		$('#cepForm').each(function () {
			this.reset();			
		});		
	}
	
});