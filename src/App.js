import 'bootstrap/dist/css/bootstrap.min.css'
import './App.css';
import {useEffect, useState} from "react";
import {addComment, fetchComments} from "./_api/comment.service";
import Comments from "./components/Comments";
import CommentForm from "./components/CommentForm";
import Kusnir_Nine_Mens_morris from "./components/game/Kusnir_Nine_Mens_Morris/Kusnir_Nine_Mens_morris";
import Nine_mens_morris_field_service
    from "./components/game/Kusnir_Nine_Mens_Morris/_api/nine_mens_morris_field_service";

function App() {
    const selectedGame ="nine_mens_morris";
    const [comments, setComments,] = useState([]);
    const loggedPlayer = "red";
    const fetchData = () => {
        fetchComments(selectedGame).then(response => {
            setComments(response.data);
        });
    }
    useEffect(() => {
        fetchData();
    }, []);

    const handleSendComment = (comment) => {
        addComment(selectedGame,loggedPlayer,comment).then(response => {
            fetchData();
        });
    }

  return (
    <div className="App container-fluid mt-4 mb-5">
      <h1>Gamestudio</h1>
        Selected game: {selectedGame};
        <Kusnir_Nine_Mens_morris/>
        <h1>Comments</h1>
        <Comments comments={comments}/>
        <h2>Add comment:</h2>
        <CommentForm game={selectedGame} player={loggedPlayer} onSendComment={handleSendComment}/>
    </div>
  );
}

export default App;
