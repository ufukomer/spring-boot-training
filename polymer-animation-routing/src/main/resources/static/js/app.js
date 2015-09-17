var app = document.querySelector('#app');
app.page = 'posts';

// Define routes
page('/', posts);
page('/posts', posts);
page('/projects', projects);
page('/about', about);

// Configure
page({hashbang: true});

function posts() {
    app.route = 'posts';
    initAnimations();
}

function projects() {
    app.route = 'projects';
}

function about() {
    app.route = 'about';
}

function initAnimations() {
    document.addEventListener('WebComponentsReady', function () {
        document.querySelector('post-list').show();
    });
}