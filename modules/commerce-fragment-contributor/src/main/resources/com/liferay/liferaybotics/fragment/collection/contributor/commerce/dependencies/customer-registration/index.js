if (!fragmentNamespace) // If it is not set then we are in fragment editor
	return;

if (document.body.classList.contains('has-edit-mode-menu')) // If present then we are in content page editor
	return;

if (!document.queryInnerTextAll || !document.queryInnerText) {
	// find all elements with inner text matching a given regular expression
	// args: 
	//      selector: string query selector to use for identifying elements on which we 
	//                should check innerText
	//      regex: A regular expression for matching innerText; if a string is provided,
	//             a case-insensitive search is performed for any element containing the string.
	Object.prototype.queryInnerTextAll = function(selector, regex) {
		if (typeof(regex) === 'string') regex = new RegExp(regex, 'i'); 
		const elements = [...this.querySelectorAll(selector)];
		const rtn = elements.filter((e)=>{
			return e.innerText.match(regex);
		});

		return rtn.length === 0 ? null : rtn
	}

	// find the first element with inner text matching a given regular expression
	// args: 
	//      selector: string query selector to use for identifying elements on which we 
	//                should check innerText
	//      regex: A regular expression for matching innerText; if a string is provided,
	//             a case-insensitive search is performed for any element containing the string.
	Object.prototype.queryInnerText = function(selector, text){
		return this.queryInnerTextAll(selector, text)[0];
	}
}

const enableDebug = configuration.enableDebug;
const enableMenuText = configuration.enableMenuText;
const runMenuTextOnload = configuration.runMenuTextOnload;
const enableRegisterPage = configuration.enableRegisterPage;
const runRegisterPageOnload = configuration.runRegisterPageOnload;

var menuTextFunc = undefined;
if (enableMenuText) {
	menuTextFunc = () => {
		const menuText = configuration.menuText;
		const _navbarMenu = document.querySelector("div.navbar-menu");
		const _registerSpan = _navbarMenu.queryInnerText("span", menuText);

		if (_registerSpan) {
			const _li = _registerSpan.closest("li");
			if (_li) {
				if (themeDisplay.isSignedIn()) {
					_li.style.display = "none";
				} else {
					_li.style.display = "";
				}
			}
		}
	};
}

var registerPageFunc = undefined;
if (enableRegisterPage) {
	var registerPageFunc = () => {
		const registerPageUrl = configuration.registerPageUrl;
		const _loginContainer = document.querySelector("div.login-container");
		if (_loginContainer) {
			const _createAccount = document.querySelector("div.navigation a[href*='create_account']", _loginContainer);
			if (_createAccount) {
				var getUrl = window.location;
				_createAccount.setAttribute("href", getUrl.protocol + "//" + getUrl.host + registerPageUrl);
			}
		}
	}
}

if (!menuTextFunc && !registerPageFunc) {
	if (enableDebug)
		console.debug("No functions enabled");
	return;
}

if (runMenuTextOnload || runRegisterPageOnload) {
	document.addEventListener("DOMContentLoaded", function(event) {
		if (runMenuTextOnload && menuTextFunc) {
			if (enableDebug)
				console.debug("Running menu-text on load");
			menuTextFunc();
		}

		if (runRegisterPageOnload && registerPageFunc) {
			if (enableDebug)
				console.debug("Running register-page on load");
			registerPageFunc();
		}
	});
}

if (!runMenuTextOnload && menuTextFunc) {
	if (enableDebug)
		console.debug("Running menu-text immediately");
	menuTextFunc();
}

if (!runRegisterPageOnload && registerPageFunc) {
	if (enableDebug)
		console.debug("Running register-page immediately");
	registerPageFunc();
}