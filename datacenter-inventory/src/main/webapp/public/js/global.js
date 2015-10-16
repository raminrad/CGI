(function ($) {
	$(document).ready(function() {
		//evt.preventDefault();

		$('.login').on('click', function(evt) {
			evt.preventDefault();
			
			if (validateLogin()) {
				$('.login').hide();
				$('.main-menu').show();
			}
		});

		$('.main-menu a').click(function(evt) {
			evt.preventDefault();
			navigate('.' + $(this).attr('dest'));
		});
		
		function validateLogin() {
			var userID = $('#userid').val();
			var password = $('#password').val();

			if (userID === 'admin' && password === 'password') {
				return true;
			}
			$('.incorrect').show();

			return false;
		}

		function navigate(navClass) {
			$('.container').hide();
			$(navClass).show();
		}
	});

})(jQuery);
