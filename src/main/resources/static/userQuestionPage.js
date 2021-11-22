// TODO: Display responses object contents in HTML

function changeToResponseTestPage(e)
{
    e.preventDefault();

    var selectedVal;
    var ele = document.getElementsByTagName('input');
    for (i = 0; i < ele.length; i++)
    {
        if (ele[i].type == "radio")
        {
            if (ele[i].checked)
            {
                selectedVal = "level=" + ele[i].value;
            }
        }
    }
    fetch("/responses", {method: "POST", body: selectedVal })
        .then(res => res.json())
        .then(
        data => {
            console.log(data);
            location.href = 'userPage.html';
        })
}

function startHiddenTimer()
{
    fetch("/responses/starttimer", {method: "GET"})
        .then(res => res.json())
}

startHiddenTimer();