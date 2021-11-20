// TODO: Display responses object contents in HTML

function startHiddenTimer()
{
    fetch("/responses/starttimer", {method: "GET"})
        .then(res => res.json())
}

startHiddenTimer();