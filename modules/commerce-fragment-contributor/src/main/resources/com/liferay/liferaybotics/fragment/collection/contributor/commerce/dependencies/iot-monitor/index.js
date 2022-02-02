if (!fragmentNamespace) // If it is not set then we are in fragment editor
	return;

if (document.body.classList.contains('has-edit-mode-menu')) // If present then we are in content page editor
	return;

const enableDebug = configuration.enableDebug;
const enableCommissionedRobots = configuration.enableCommissionedRobots;
const simulateIot = configuration.simulateIot;
const cookieExpiry = parseFloat(configuration.cookieExpiry);
const productId = configuration.productId;
const productPurchased = configuration.productPurchased;
const redirectDelay = parseInt(configuration.redirectDelay);
const productPageUrl = configuration.productPageUrl;

var locked = false;
var lastCall = false;

function runOnScroll(evt) {
  if(locked) return;
	locked = true;
	
	if (fragmentElement) {
		var isVisible = checkVisible(fragmentElement);
		
		if (enableDebug)
			console.debug(isVisible ? "fragment is visible" : "fragment is not visible");
		
		if (!isVisible) {
			const badge = fragmentElement.querySelector("div.first-robot").querySelector("span.label");
			
			if (badge.classList.contains("label-success")) {
				badge.classList.replace("label-success", "label-danger");
				badge.firstElementChild.textContent = "Issue";
				if (enableDebug) {
					console.debug("removing listener");
				}
				window.removeEventListener("scroll", runOnScroll);				
			}			
		}
	}
	
  locked = false;
}

function checkVisible(elm) {
  var rect = elm.getBoundingClientRect();
  var viewHeight = Math.max(document.documentElement.clientHeight, window.innerHeight);
  return !(rect.bottom < 0 || rect.top - viewHeight >= 0);
}

let getCookie = function(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) return c.substring(name.length,c.length);
    }
    return "";
}
let setCookie = function(cname, cvalue, expires) {
   document.cookie = cname + "=" + cvalue + "; " + expires;
}
let runCommissionedRobots = function(e) {
	var d = new Date();
	if (isNaN(cookieExpiry)) {
		d.setTime(d.getTime() + (10000));
	} else {
		d.setTime(d.getTime() + (cookieExpiry * 1000));
	}
	const expires = d.toUTCString();
	if (enableDebug) {
		console.debug("The product id is " + productId);
		console.debug("Product purchased is " + productPurchased);
		console.debug("The cookie will expire at " + expires);
		console.debug("Page will redirect to " + productPageUrl + " in " + redirectDelay + " milliseconds");
	}

  const expiryStr = "expires=" + expires;
	setCookie("product", productId, expiryStr);
	setCookie("purchased", productPurchased, expiryStr);
	
	setTimeout(() => {
		const currentLocation = window.location;
		location.href = currentLocation.protocol + "//" + currentLocation.host + productPageUrl;
	}, redirectDelay);
};

if (enableCommissionedRobots) {
	let a = fragmentElement.querySelector("div.first-robot");
	if (a) {
		a.addEventListener("click", runCommissionedRobots, false);
		if (enableDebug) {
			console.debug("Event handled added for commissioned robots");
		}
	}
}

if (simulateIot) {
	window.addEventListener("scroll", runOnScroll, {passive: true});
		if (enableDebug) {
			console.debug("Event handled added for IoT simulation");
		}

}