$(document).ready(function(){
	const _registerSpan = $("span:contains('Register')");
	if (_registerSpan) {
		const _li = _registerSpan.parents("li");
		if (_li) {
			if (themeDisplay.isSignedIn()) {
				_li.css("display","none");
			} else {
				_li.css("display","");
			}
		}
	}
	const _loginContainer = $("div.login-container");
	if (_loginContainer) {
		const _createAccount = $("div.navigation a[href*='create_account']", _loginContainer);
		if (_createAccount) {
			var getUrl = window.location;
			_createAccount.attr("href", getUrl.protocol + "//" + getUrl.host + "/web/liferaybotics/register");
		}
	}
});