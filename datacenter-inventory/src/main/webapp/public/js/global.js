(function ($) {
	$(document).ready(function() {
		$('.login').on('click', function(evt) {
			evt.preventDefault();
			
			if (validateLogin()) {
				navigate('.main-menu');
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
			initScreen(navClass);
		}

		function initScreen(navClass) {
			if (navClass == '.data-center-selection') {
				var datacenters = $.ajax({
					url: 'js/Datacenters.json'
				}).success(function(result) {
					console.log(result);
					$.each(result.data, function(key, value) {
						$('.datacenter-list').append('<li>' + value.datacenterInformation.agencyDataCenterId + ' - ' + value.address.city + ' ' + value.address.state + ', ' + value.address.zip + '</li>');
					});
				});
			}
		}
	});

})(jQuery);
