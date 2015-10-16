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

		function validateLogin() {
			var userID = $('#userid').val();
			var password = $('#password').val();

			if (userID === 'admin' && password === 'password') {
				return true;
			}
			return false;
		}
	});

})(jQuery);
