<template>
    <header-line/>
    <div class="app">
        <book-form
            @create="createBook"           
        />
        <book-list 
                   :books="books"
                   />
    </div>
</template>

<script>
    import BookForm from "./components/BookForm";
    import BookList from "./components/BookList";
    import HeaderLine from "./components/HeaderLine"
    export default {
        components: {
            BookList, BookForm, HeaderLine
        },
        data() {
            return {
                books: [
                    { id: 1, title: 'Гарри Поттер и Узник Азкабана', author: 'Дж. Роулинг', img_path: 'HP3' },
                    { id: 2, title: 'Гарри Поттер и Орден Феникса', author: 'Дж. Роулинг', img_name: 'HP5' },
                    { id: 3, title: 'Гарри Поттер и Принц-полукровка', author: 'Дж. Роулинг', img_name: 'HP6' },
                    { id: 4, title: 'Гарри Поттер и Дары смерти', author: 'Дж. Роулинг', img_name: 'HP7' },
                    { id: 5, title: 'Гарри Поттер и Философский камень', author: 'Дж. Роулинг', img_name: 'HP7' }
                ],
            }
        },
        methods: {
            createBook(book) {
                this.books.push(book);
            },
           
        }
    }

</script>

<style>
    body {
        background-color: #767384;
        font-family: Helvetica;
        font-weight: 500;
    }
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    .app {
        padding: 2%;
        padding-bottom: 500px;
        border-radius: 30px;
        background: #f5f5f5;
    }

    

    
    
   

    
</style>