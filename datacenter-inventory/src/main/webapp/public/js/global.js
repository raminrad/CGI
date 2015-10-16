var endpoints = {
	'datacenters' : 'js/Datacenters.json'
};

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

		$('.manage-password').click(function(evt) {
			evt.preventDefault();
			navigate('.forgot-password');
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
					url: endpoints.datacenters
				}).success(function(result) {
					console.log(result);
					$.each(result.data, function(key, value) {
						$('.datacenter-list').append(
							'<li>' +
							'<a href="/update/' + value.id + '" datacenter=' + value.id + '>' + value.datacenterInformation.agencyDataCenterId + '</a>' +
							' - ' + value.address.city + ' ' + value.address.state + ', ' + value.address.zip + '</li>'
						);
					});
				});
			}
		}
	});

})(jQuery);
