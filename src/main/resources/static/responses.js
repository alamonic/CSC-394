// TODO: Display responses object contents in HTML

let responses = fetch("/responses")
        .then(res => res.json())
        .then(data => {
            console.log(data);
        })
