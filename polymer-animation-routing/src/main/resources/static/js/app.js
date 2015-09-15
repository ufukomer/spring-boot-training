var app = document.querySelector('#app');
app.page = 'posts';

// Define routes
page('/', posts);
page('/posts', posts);
page('/projects', projects);
page('/about', about);

// Configure
page({ hashbang: true });

function posts() {
    app.route = 'posts';
}

function projects() {
    app.route = 'projects';
}

function about() {
    app.route = 'about';
}