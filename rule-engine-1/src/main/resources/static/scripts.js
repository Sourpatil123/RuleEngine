// Function to show the relevant section with smooth transition
function showSection(sectionId) {
    const sections = document.querySelectorAll('.section');
    sections.forEach(section => {
        section.style.display = 'none';
        section.classList.remove('active');
    });
    const activeSection = document.getElementById(sectionId);
    activeSection.style.display = 'block';
    setTimeout(() => {
        activeSection.classList.add('active');
    }, 10); // Delay for smooth transition
}

document.addEventListener('DOMContentLoaded', () => {
    showSection('home');
});
