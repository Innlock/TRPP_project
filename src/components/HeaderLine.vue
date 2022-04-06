<template>
    <div class="header_line">
        <div class="header_content">
            <div class="user">
                <div>Макс Вишняков</div>
            </div>
            <button class="ad_button">Разместить объявление</button>
        </div>
    </div>
</template>

<script>
    
</script>

<style>
    .header_line {
        background: #767384;
        padding: 1%;
        padding-right: 4%;
        color: #f9f1ef;
    }
    .ad_button {
        padding: 6px;
        padding-top: 10px;
        padding-bottom: 10px;
        margin: 0.5%;
        width: 10%;
        min-width: 200px;
        border-radius: 5px;
        border: none;
        background: #e3d9e4;
        color: #000;
    }
    .header_content {
        display:flex;
        justify-content: right;
    }
    .user {

        text-align: center;
        padding: 2px;
        padding-top: 10px;
        padding-bottom: 10px;
        margin-right: 0;
        margin: 0.5%;
        width: 8%;
        min-width: 120px;
        white-space: nowrap;
    }
</style>