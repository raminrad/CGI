(function ($) {
	$(document).ready(function() {
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
			$('.content-screen').hide();
			$(navClass).show();
		}
	});

})(jQuery);
