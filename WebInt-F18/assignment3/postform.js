let newPostForm;
let newPostPosted;
let nameFirst;
let nameLast;
let email;
let phone;

function makeNewPost() {
  nameFirst = document.querySelector("#nameFirst").value;
  nameLast = document.querySelector("#nameLast").value;
  email = document.querySelector("#email").value;
  phone = document.querySelector("#phone").value;

  const outString = `${nameFirst} ${nameLast}: ${email} #${phone}`;

  newPostPosted.innerHTML = newPostPosted.innerHTML + outString + "\n";
  return false;
}

document.addEventListener("DOMContentLoaded", function() {
  newPostForm = document.querySelector("#newPostForm");
  newPostForm.onsubmit = makeNewPost;
  newPostPosted = document.querySelector("#newPostPosted");
});
