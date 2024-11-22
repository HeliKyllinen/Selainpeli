const style = document.createElement('style');
style.innerHTML = `
        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            padding: 20px;
            background: linear-gradient(to right, #cfcff6, #b7e6b7);
        }

        h1 {
            font-family: 'Roboto Slab', serif;
            text-transform: uppercase;
            color: white;
            font-size: 50px;
        }

        #puzzleContainer {
            display: none;
            grid-template-columns: repeat(4, 1fr);
            grid-template-rows: repeat(4, 1fr);
            gap: 1px;
            position: relative;
            border: 2px solid #333;
            background-image: linear-gradient(to right, #333 1px, transparent 1px),
                linear-gradient(to bottom, #333 1px, transparent 1px);
            background-size: calc(100% / 4) calc(100% / 4);
            overflow: hidden;
        }

        .puzzlePiece {
            position: absolute;
            border: 1px solid #333;
            cursor: pointer;
            width: 100px;
            height: 100px;
            z-index: 1;
        }

        #searchSection {
            margin-bottom: 10px;
        }

        .custom-button {
        background-color: #e0d2e6;
        border-color: #e0d2e6;   
        color: gray;             
        }

        .custom-button:hover {
        background-color: #c7aed1;
        border-color: #c7aed1;
        }

        #gallery1 {
            margin-bottom: 10px;
        }

        #completedMessage {
            display: none;
            margin-top: 20px;
            font-size: 24px;
            color: green;
        }

        a {
            margin-bottom: 20px;
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        #gallery {
            display: grid;
            grid-template-columns: repeat(5, 1fr); 
            gap: 20px; 
            padding: 0;
            margin: 0;
            list-style: none;
        }

        #gallery li {
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: #fff;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        #gallery img {
            max-width: 100%;
            height: auto;
            border-radius: 5px;
        }

        #gallery p {
            margin: 10px 0 0;
            font-size: 14px;
            color: #333;
        }

           .card {
            background-color: white;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin: 10px;
            padding: 10px;
            flex: 1 1 calc(20% - 20px); 
            max-width: calc(20% - 20px);
            box-sizing: border-box;
        }

        .card img {
            max-width: 100%;
            border-radius: 4px;
        }

        .card p {
            margin: 10px 0;
        }

        .card button {
            background-color: #f44336;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
        }

        .card button:hover {
            background-color: #d32f2f;
        }

        #gallery2 {
            display: flex;
            flex-wrap: wrap;
            gap: 10px; 
            justify-content: center;
        }
 `;
document.head.appendChild(style);