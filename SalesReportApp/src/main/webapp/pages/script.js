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