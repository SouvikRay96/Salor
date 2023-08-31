const readMore = document.querySelector(".btn");
const extramsg = document.querySelector('.extramsg');

let flag = 0;
//For Reading More Information About the Application
const ReadMore = function () {
  if (flag == 0) {
    extramsg.classList.remove("hidden");
    readMore.textContent = "Read Less";
    flag = 1;
  } else {
    extramsg.classList.add("hidden");
    readMore.textContent = "Read More";
    flag = 0;
  }
};
//The ReadMore Button Event Listener
readMore.addEventListener("click", ReadMore);

let signup = document.querySelector(".signup");
let login = document.querySelector(".login");
let slider = document.querySelector(".slider");
let formSection = document.querySelector(".form-section");

signup.addEventListener("click", () => {
	slider.classList.add("moveslider");
	formSection.classList.add("form-section-move");
});

login.addEventListener("click", () => {
	slider.classList.remove("moveslider");
	formSection.classList.remove("form-section-move");
});
